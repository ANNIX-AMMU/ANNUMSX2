package com.armsx2.enumsx2
import com.armsx2.config.Settings
import org.junit.Assert.*
import org.junit.Test
class Enumsx2ShaderStutterProfileTest {
 @Test fun baseline(){val s=Enumsx2ShaderStutterProfile.apply(Settings());assertFalse(s.graphics.disableShaderCache);assertFalse(s.graphics.shaderChainEnabled);assertEquals(1,s.graphics.texturePreloading);assertEquals(0,s.graphics.hardwareDownloadMode);assertTrue(s.display.coalesceRenderPasses);assertEquals(0,s.display.gsBackThreadMode);assertFalse(s.display.forceMaliFbFetch)}
 @Test fun lightChain(){val s=Enumsx2ShaderStutterProfile.lightweightShaderChain(Settings());assertTrue(s.graphics.shaderChainEnabled);assertEquals(67,s.graphics.shaderChainScale)}
}
