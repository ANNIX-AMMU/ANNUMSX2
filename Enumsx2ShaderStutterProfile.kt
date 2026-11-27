package com.armsx2.enumsx2
import com.armsx2.config.Settings

object Enumsx2ShaderStutterProfile {
 fun apply(b: Settings)=b.copy(
  output=b.output.copy(renderer="vulkan",upscaleFloat=1.0f),
  graphics=b.graphics.copy(disableShaderCache=false,shaderChainEnabled=false,shaderChainScale=67,fxaa=false,texturePreloading=1,hardwareDownloadMode=0),
  display=b.display.copy(coalesceRenderPasses=true,gsBackThreadMode=0,useBlitSwapChain=false,forceMaliFbFetch=false),
  hwFixes=b.hwFixes.copy(vsyncQueueSize=2,spinGpuReadbacks=false,spinCpuReadbacks=false)
 )
 fun lightweightShaderChain(b: Settings)=apply(b).let{s->s.copy(graphics=s.graphics.copy(shaderChainEnabled=true,shaderChainScale=67))}
}
