package com.tbo.sn;

import com.tbo.sn.config.AppConfig;
import com.tbo.sn.config.AppTestDataConfig;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tai
 * @since 3/24/18.
 */
@SpringBootTest(classes = AppConfig.class )
// Do not forget to add @RunWith(SpringRunner.class) to your test.
// Otherwise, the annotations are ignored.
@RunWith( SpringRunner.class )
@Ignore
public class AppTest
{
}
