package com.armsx2.enumsx2

import com.armsx2.config.Settings
import org.junit.Assert.*
import org.junit.Test

class Enumsx2Beta3ProfileTest {
    @Test fun beta3PreservesKnownGoodConservativePaths() {
        val s = Enumsx2Beta3Profile.apply(Settings())
        assertEquals(0, s.cpu.eeCycleRate)
        assertEquals(0, s.cpu.eeCycleSkip)
        assertFalse(s.cpu.dynamicEeCycleRate)
        assertEquals(7, s.display.affinityMode)
        assertTrue(s.display.coalesceRenderPasses)
        assertEquals(0, s.graphics.hardwareDownloadMode)
        assertFalse(s.graphics.disableShaderCache)
        assertEquals(2, s.hwFixes.vsyncQueueSize)
        assertFalse(s.cpu.vu1InlineFmacStall)
        assertFalse(s.cpu.vu1CrossBlockPState)
        assertFalse(s.cpu.vu1InlineDrainTestPipes)
        assertFalse(s.cpu.vu1FmacInstanceRouting)
    }
}
