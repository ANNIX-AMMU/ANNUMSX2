package com.armsx2.enumsx2

import com.armsx2.config.Settings

/**
 * ANNUMSX2 v0.1.2 Beta 3 refinement profile.
 * Preserves the Beta 2 known-good timing/readback baseline and focuses on
 * sustained frame pacing, cache reuse and mobile tiler efficiency.
 */
object Enumsx2Beta3Profile {
    fun apply(base: Settings): Settings = base.copy(
        cpu = base.cpu.copy(
            eeCycleRate = 0,
            eeCycleSkip = 0,
            dynamicEeCycleRate = false,
            mtvu = true,
            vuAot = true,
            recEE = true,
            recIOP = true,
            recVU0 = true,
            recVU1 = true,
            enableFastmem = true,
            vuNeonFusions = true,
            vuDeferredWrites = false,
            vuSkipStallSim = false,
            // Keep Beta 2 experimental VU pipeline paths opt-in/per-game.
            vu1InlineFmacStall = false,
            vu1CrossBlockPState = false,
            vu1InlineDrainTestPipes = false,
            vu1FmacInstanceRouting = false
        ),
        display = base.display.copy(
            // Existing safe default: use the performance-core tier while
            // leaving Android EAS free to place threads within that tier.
            affinityMode = 7,
            hwRov = false,
            coalesceRenderPasses = true,
            gsBackThreadMode = 0
        ),
        output = base.output.copy(
            renderer = "vulkan",
            upscaleFloat = 1.0f
        ),
        graphics = base.graphics.copy(
            texturePreloading = 1,
            maxAnisotropy = 0,
            fxaa = false,
            shaderChainEnabled = false,
            hardwareDownloadMode = 0,
            disableShaderCache = false
        ),
        hwFixes = base.hwFixes.copy(
            vsyncQueueSize = 2,
            spinGpuReadbacks = false,
            spinCpuReadbacks = false
        )
    )
}
