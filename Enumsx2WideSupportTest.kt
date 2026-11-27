package com.armsx2.enumsx2
import com.armsx2.config.Settings
import org.junit.Assert.*
import org.junit.Test
class Enumsx2WideSupportTest{
 @Test fun detection(){assertEquals(Enumsx2GpuFamily.ADRENO,Enumsx2WideSupport.detect(listOf("Adreno 740")));assertEquals(Enumsx2GpuFamily.MALI,Enumsx2WideSupport.detect(listOf("Mali-G615")));assertEquals(Enumsx2GpuFamily.POWERVR,Enumsx2WideSupport.detect(listOf("A67L","SC9863")));assertEquals(Enumsx2GpuFamily.XCLIPSE,Enumsx2WideSupport.detect(listOf("Xclipse 940")));assertEquals(Enumsx2GpuFamily.AUTO,Enumsx2WideSupport.detect(listOf("Unknown")))}
 @Test fun unknownIsAuto(){assertEquals(0,Enumsx2WideSupport.apply(Settings(),Enumsx2GpuFamily.AUTO).graphics.gpuProfile)}
}
