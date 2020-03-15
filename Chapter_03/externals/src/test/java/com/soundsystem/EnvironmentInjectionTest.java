package com.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

public class EnvironmentInjectionTest {
    //测试 getProperty
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = EnvironmentConfig.class)
    public static class InjectFromProperties {
        @Autowired
        private BlankDisc blankDisc;

        @Test
        public void assertBlankDiscProperties() {
            assertEquals("The Beatles", blankDisc.getArtist());
            assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
        }
    }

    //测试 getProperty 默认值
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = EnvironmentConfigWithDefaults.class)
    public static class InjectFromPropertiesWithDefaultValues {
        @Autowired
        private BlankDisc blankDisc;

        @Test
        public void assertBlankDiscProperties() {
            assertEquals("U2", blankDisc.getArtist());  // 使用默认值
            assertEquals("Rattle and Hum", blankDisc.getTitle());
        }
    }

    // 测试 getRequiredProperty
    public static class InjectFromPropertiesWithRequiredProperties {
        @Test(expected = BeanCreationException.class)
        public void assertBlankDiscProperties() {
            new AnnotationConfigApplicationContext(EnvironmentConfigWithRequiredProperties.class);
        }
    }

    //测试 使用解析属性占位符
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:placeholder-config.xml")
    public static class InjectFromProperties_XMLConfig {
        @Autowired
        private BlankDisc blankDisc;

        @Test
        public void assertBlankDiscProperties() {
            assertEquals("The Beatles", blankDisc.getArtist());
            assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
        }
    }
}
