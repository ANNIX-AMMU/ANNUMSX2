package com.armsx2.enumsx2

import com.armsx2.config.Settings
import org.junit.Assert.*
import org.junit.Test

class Enumsx2PerformanceProfilesTest {
    @Test fun safeProfileIsConservative() {
        val s = Enumsx2PerformanceProfiles.safeMobile(Settings())
        assertEquals(0, s.cpu.eeCycleRate)
        assertEquals(0, s.cpu.eeCycleSkip)
        assertEquals(0, s.graphics.hardwareDownloadMode)
        assertFalse(s.cpu.vu1InlineFmacStall)
        assertTrue(s.display.coalesceRenderPasses)
        assertFalse(s.graphics.disableShaderCache)
    }

    @Test fun experimentalProfileEnablesOptInPaths() {
        val s = Enumsx2PerformanceProfiles.experimental(Settings())
        assertTrue(s.cpu.vu1InlineFmacStall)
        assertTrue(s.cpu.vu1CrossBlockPState)
        assertTrue(s.cpu.vu1InlineDrainTestPipes)
        assertFalse(s.cpu.vu1FmacInstanceRouting)
        assertEquals(5, s.graphics.hardwareDownloadMode)
        assertEquals(1, s.display.gsBackThreadMode)
    }
}
