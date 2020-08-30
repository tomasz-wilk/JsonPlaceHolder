package com.epam.wilk.tests;

import com.epam.wilk.configuration.TestConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ContextConfiguration(classes = {TestConfiguration.class})
@ExtendWith(SpringExtension.class)
public class BaseIT {
}
