package com.example.application.applicationservice.service;

import com.example.application.applicationservice.repository.UserRepository;
import com.example.application.applicationservice.util.TokenUtil;
import com.example.application.domain.model.User;
import com.example.application.domain.model.UserGroup;
import com.vaadin.flow.component.UI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MailService mailService;

    @Value("${mail.from}")
    private String mailFrom;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, MailService mailService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    public User createUser(User user) {
        user.setEnabled(true);
        user = generatePassword(user, true);
	    // We need to do this because Vaadin Binder changes userGroups to an unmodifiable set.
	    // Hibernate later calls a .clear() on that set. That fails.
	    Set<UserGroup> userGroups = new HashSet<>(user.getUserGroups());
        user.setUserGroups(userGroups);

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUser(String email) {
        return userRepository.findOneByEmail(email);
    }

    public void forgotPassword(String email) {
        generatePassword(getUser(email), false);
    }

    private User generatePassword(User user, boolean initial) {
        if (null != user) {
            String passwordResetToken = TokenUtil.generateRandomToken();
            user.setPasswordResetToken(passwordResetToken);
            try {
                sendPasswordMail(user, passwordResetToken, initial);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

            return this.userRepository.saveAndFlush(user);
        }
        return null;
    }

    private void sendPasswordMail(User user, String passwordToken, boolean initial) throws URISyntaxException {
	    URI uri = new URI("/");
        StringBuilder passwordResetUrl = new StringBuilder();
        passwordResetUrl.append(uri.getScheme());
        passwordResetUrl.append("://");
        passwordResetUrl.append(uri.getAuthority());
        passwordResetUrl.append("/?token=");
        passwordResetUrl.append(passwordToken);
        passwordResetUrl.append("#!PasswordReset");
    	final Context ctx = new Context();
        ctx.setVariable("user", user);
        ctx.setVariable("passwordResetUrl", passwordResetUrl.toString());
        ctx.setVariable("passwordToken", passwordToken);

        if (initial) {
	        mailService.sendMail(mailFrom, user.getEmail(), "Video Transcoding account information", "newUser", ctx);
        } else {
	        mailService.sendMail(mailFrom, user.getEmail(), "Video Transcoding account information", "passwordForgot", ctx);
        }
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public List<User> findByFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrEmailLikeIgnoreCase(String likeFilter) {
        return this.userRepository.findByFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrEmailLikeIgnoreCase(likeFilter, likeFilter, likeFilter);
    }

    public User save(User user) {
    	if (StringUtils.isEmpty(user.getPassword())) {
		    user = createUser(user);
	    }
	    if (null != user) {
		    return this.userRepository.save(user);
	    }
	    return null;
    }

    public void delete(User user) {
    	this.userRepository.delete(user);
    }

	public void updatePasswordViaToken(String token, String password) {
		User user = this.findOneByPasswordResetToken(token);
		user.setPassword(passwordEncoder.encode(password));
		user.setPasswordResetToken(null);
		this.save(user);
	}

	private User findOneByPasswordResetToken(String token) {
		return this.userRepository.findOneByPasswordResetToken(token);
	}
}