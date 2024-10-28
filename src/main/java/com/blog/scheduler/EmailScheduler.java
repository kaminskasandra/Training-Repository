package com.blog.scheduler;

import com.blog.domain.Post;
import com.blog.domain.User;
import com.blog.dto.UserDto;
import com.blog.exceptions.UserNotFoundException;
import com.blog.service.MailService;
import com.blog.service.PostService;
import com.blog.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private static final String SUBJECT = "Reminder about new comments in your posts";
    private final UserService userService;
    private final MailService mailService;
    private final PostService postService;

    @Scheduled(cron = "0 0 7 * * *")
    @Transactional
    public void sendInformationEmail() throws UserNotFoundException {
    }
}