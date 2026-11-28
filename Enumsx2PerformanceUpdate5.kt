package com.armsx2.enumsx2
import com.armsx2.config.Settings
object Enumsx2PerformanceUpdate5{
 fun stable(b:Settings)=b.copy(cpu=b.cpu.copy(eeCycleRate=0,eeCycleSkip=0,mtvu=true,vuAot=true,recEE=true,recIOP=true,recVU0=true,recVU1=true,enableFastmem=true,vuNeonFusions=true,vu1InlineFmacStall=false,vu1CrossBlockPState=false,vu1InlineDrainTestPipes=false,vu1FmacInstanceRouting=false),display=b.display.copy(affinityMode=7,coalesceRenderPasses=true,gsBackThreadMode=0),graphics=b.graphics.copy(disableShaderCache=false,texturePreloading=1,hardwareDownloadMode=0),hwFixes=b.hwFixes.copy(vsyncQueueSize=2,spinGpuReadbacks=false,spinCpuReadbacks=false))
 fun jitBoost(b:Settings)=stable(b).let{s->s.copy(cpu=s.cpu.copy(vu1InlineFmacStall=true,vu1CrossBlockPState=true,vu1InlineDrainTestPipes=true,vu1FmacInstanceRouting=false))}
 fun gpuLatencyTest(b:Settings)=stable(b).let{s->s.copy(graphics=s.graphics.copy(hardwareDownloadMode=5),display=s.display.copy(gsBackThreadMode=1))}
}
