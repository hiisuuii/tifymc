package hisui.tifymc.annotation;

import io.wispforest.owo.config.Option;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SuppressWarnings("unused")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigurableMixin {

    String configName();

    boolean applyIfPresent() default true;
}
