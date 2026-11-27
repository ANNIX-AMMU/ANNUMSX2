package com.armsx2.enumsx2

import com.armsx2.config.Settings

object Enumsx2PerformanceProfiles {
    fun safeMobile(base: Settings): Settings = base.copy(
        cpu = base.cpu.copy(
            eeCycleRate = 0, eeCycleSkip = 0, mtvu = true, vuAot = true,
            recEE = true, recIOP = true, recVU0 = true, recVU1 = true,
            enableFastmem = true, vuNeonFusions = true,
            vuDeferredWrites = false, vuSkipStallSim = false,
            vu1InlineFmacStall = false, vu1CrossBlockPState = false,
            vu1InlineDrainTestPipes = false, vu1FmacInstanceRouting = false
        ),
        output = base.output.copy(renderer = "vulkan", upscaleFloat = 1.0f),
        graphics = base.graphics.copy(
            texturePreloading = 1, maxAnisotropy = 0, fxaa = false,
            shaderChainEnabled = false, hardwareDownloadMode = 0,
            disableShaderCache = false, gpuProfile = 3
        ),
        display = base.display.copy(
            hwRov = false, coalesceRenderPasses = true, gsBackThreadMode = 0
        ),
        hwFixes = base.hwFixes.copy(
            vsyncQueueSize = 2, spinGpuReadbacks = false, spinCpuReadbacks = false
        )
    )

    fun experimental(base: Settings): Settings {
        val safe = safeMobile(base)
        return safe.copy(
            cpu = safe.cpu.copy(
                vu1InlineFmacStall = true,
                vu1CrossBlockPState = true,
                vu1InlineDrainTestPipes = true,
                vu1FmacInstanceRouting = false
            ),
            graphics = safe.graphics.copy(hardwareDownloadMode = 5),
            display = safe.display.copy(gsBackThreadMode = 1)
        )
    }
}
