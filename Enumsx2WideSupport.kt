package com.armsx2.enumsx2
import com.armsx2.config.Settings
enum class Enumsx2GpuFamily(val profile:Int){AUTO(0),MALI(1),ADRENO(2),POWERVR(3),XCLIPSE(4)}
object Enumsx2WideSupport{
 private fun n(s:String?)=s.orEmpty().lowercase().replace("-","").replace("_","").replace(" ","")
 fun detect(v:Iterable<String?>):Enumsx2GpuFamily{val s=v.map(::n).joinToString("|");return when{
  s.contains("adreno")||s.contains("snapdragon")||s.contains("qualcomm")->Enumsx2GpuFamily.ADRENO
  s.contains("mali")||s.contains("mediatek")||s.contains("dimensity")->Enumsx2GpuFamily.MALI
  s.contains("powervr")||s.contains("sc9863")||s.contains("a67l")->Enumsx2GpuFamily.POWERVR
  s.contains("xclipse")->Enumsx2GpuFamily.XCLIPSE
  else->Enumsx2GpuFamily.AUTO}}
 fun apply(b:Settings,f:Enumsx2GpuFamily):Settings=b.copy(
  output=b.output.copy(renderer="vulkan",upscaleFloat=1.0f),
  graphics=b.graphics.copy(gpuProfile=f.profile,texturePreloading=1,maxAnisotropy=0,disableShaderCache=false,hardwareDownloadMode=0),
  display=b.display.copy(hwRov=false,coalesceRenderPasses=true,gsBackThreadMode=0,forceMaliFbFetch=false),
  hwFixes=b.hwFixes.copy(vsyncQueueSize=2))
}
