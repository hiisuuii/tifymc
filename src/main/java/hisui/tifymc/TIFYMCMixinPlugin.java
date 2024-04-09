package hisui.tifymc;

import hisui.tifymc.annotation.ConfigurableMixin;
import io.wispforest.owo.config.Option;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.Annotations;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static hisui.tifymc.ThereIFixedYourMinecraft.CONFIG;

public class TIFYMCMixinPlugin implements IMixinConfigPlugin {

    public static boolean testClass(String className) {
        try {
            List<AnnotationNode> annotationNodes = MixinService.getService()
                    .getBytecodeProvider()
                    .getClassNode(className).visibleAnnotations;
            if (annotationNodes == null) return true;

            for (AnnotationNode node : annotationNodes) {
                if (node.desc.equals(Type.getDescriptor(ConfigurableMixin.class))) {
                    String configOption = Annotations.getValue(node, "configName");

                    if(CONFIG.optionForKey(new Option.Key(configOption)) != null){
                        Option.BoundField<?> field = CONFIG.optionForKey(new Option.Key(configOption)).backingField();
                        if(field != null){
                            return (boolean)field.getValue();
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            ThereIFixedYourMinecraft.LOGGER.error("TIFYMCMixinPlugin: Failed to load class " + className + ", it will not be applied", e);
            return false;
        }
        return true;
    }

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return testClass(mixinClassName);
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
