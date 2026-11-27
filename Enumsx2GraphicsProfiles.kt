package com.armsx2.enumsx2
import com.armsx2.config.Settings
object Enumsx2GraphicsProfiles {
 fun performance(b: Settings)=b.copy(output=b.output.copy(renderer="vulkan",upscaleFloat=1.0f),graphics=b.graphics.copy(hwMipmap=true,accurateBlendingUnit=1,textureFiltering=2,texturePreloading=1,maxAnisotropy=0,fxaa=false,shaderChainEnabled=false,hardwareDownloadMode=0,disableShaderCache=false),display=b.display.copy(hwRov=false,coalesceRenderPasses=true),hwFixes=b.hwFixes.copy(manualUserHacks=false,autoFlush=0))
 fun balanced(b: Settings)=performance(b).let{s->s.copy(output=s.output.copy(upscaleFloat=1.5f),graphics=s.graphics.copy(texturePreloading=2,maxAnisotropy=2))}
 fun quality(b: Settings)=performance(b).let{s->s.copy(output=s.output.copy(upscaleFloat=2.0f),graphics=s.graphics.copy(accurateBlendingUnit=2,texturePreloading=2,maxAnisotropy=4))}
 fun compatibility(b: Settings)=b.copy(output=b.output.copy(renderer="vulkan",upscaleFloat=1.0f),graphics=b.graphics.copy(hwMipmap=true,accurateBlendingUnit=2,textureFiltering=2,texturePreloading=2,maxAnisotropy=0,fxaa=false,shaderChainEnabled=false,hardwareDownloadMode=0,disableShaderCache=false),display=b.display.copy(deinterlaceMode=0,hwRov=false,coalesceRenderPasses=false),hwFixes=b.hwFixes.copy(manualUserHacks=false,autoFlush=0,skipDrawStart=0,skipDrawEnd=0))
}
