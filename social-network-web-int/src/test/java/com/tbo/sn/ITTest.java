package com.tbo.sn;

import com.tbo.sn.config.AppConfig;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tai
 * @since 4/23/18.
 */
@RunWith( SpringRunner.class )
@SpringBootTest(classes = AppConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public abstract class ITTest
{
}
