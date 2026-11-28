package com.armsx2.enumsx2
import com.armsx2.config.Settings
import org.junit.Assert.*
import org.junit.Test
class Enumsx2PerformanceUpdate5Test{
 @Test fun stable(){val s=Enumsx2PerformanceUpdate5.stable(Settings());assertEquals(0,s.cpu.eeCycleRate);assertEquals(7,s.display.affinityMode);assertEquals(0,s.graphics.hardwareDownloadMode);assertFalse(s.cpu.vu1InlineFmacStall)}
 @Test fun jit(){val s=Enumsx2PerformanceUpdate5.jitBoost(Settings());assertTrue(s.cpu.vu1InlineFmacStall);assertTrue(s.cpu.vu1CrossBlockPState);assertTrue(s.cpu.vu1InlineDrainTestPipes);assertFalse(s.cpu.vu1FmacInstanceRouting)}
 @Test fun gpu(){val s=Enumsx2PerformanceUpdate5.gpuLatencyTest(Settings());assertEquals(5,s.graphics.hardwareDownloadMode);assertEquals(1,s.display.gsBackThreadMode)}
}
