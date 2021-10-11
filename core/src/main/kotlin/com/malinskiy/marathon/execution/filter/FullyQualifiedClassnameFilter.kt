package com.malinskiy.marathon.execution

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

class FullyQualifiedClassnameFilter(
    @JsonProperty("regex") regex: Regex? = null,
    @JsonProperty("values") values: List<String>? = null,
    @JsonProperty("file") file: File? = null,
) : SingleValueTestFilter(regex, values, file, { test, filterValues ->
    (regex?.matches("${test.pkg}.${test.clazz}") ?: true) && (filterValues?.contains("${test.pkg}.${test.clazz}") ?: true)
})
