package com.zugaldia.cloudrun.template

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class InfoResponse(
        val now: Long,
        val port: String,
        val kService: String,
        val kRevision: String,
        val kConfiguration: String,
        val javaVersion: String
)

@RestController
class RootController {

    @RequestMapping("/")
    fun root() = ResponseEntity("OK.", HttpStatus.OK)

    /**
     * This endpoint will dump a few environment variables values, together with a timestamp.
     * The goal is to make sure the values make sense and that data classes serialization works.
     * https://cloud.google.com/run/docs/reference/container-contract#env-vars
     *
     * Other standard variables are also available: PATH, JAVA_TOOL_OPTIONS, JAVA_HOME, HOME.
     */
    @GetMapping("/info")
    fun info(): InfoResponse = InfoResponse(
            now = System.currentTimeMillis(),
            port = System.getenv("PORT") ?: "(empty)",
            kService = System.getenv("K_SERVICE") ?: "(empty)",
            kRevision = System.getenv("K_REVISION") ?: "(empty)",
            kConfiguration = System.getenv("K_CONFIGURATION") ?: "(empty)",
            javaVersion = System.getenv("JAVA_VERSION") ?: "(empty)")
}
