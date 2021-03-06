/*
 * Copyright (C) 2017 - Protium - Ussoltsev Dmitry, Jankurazov Ruslan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package net.protium.api.utils

import groovy.json.JsonException
import groovy.json.JsonSlurper

class JSONParser extends AbstractJSONParser {

    static def openStream(InputStream stream) throws JsonException {
        (new JsonSlurper()).parse(stream)
    }

    static def openString(String string) throws JsonException {
        (new JsonSlurper()).parse(string.toCharArray())
    }

    JSONParser(File file, String schema = null) throws JsonException {
        this.file = file
        data = openFile(file)
	    Set valid = validate(schema)
	    if (schema != null && valid.size() > 0) {
		    throw new JsonException(valid.toString())
	    }

    }

    JSONParser(InputStream stream, String schema = null) throws JsonException {
        file = null
        data = openStream(stream)
	    Set valid = validate(schema)
	    if (schema != null && valid.size() > 0) {
		    throw new JsonException(valid.toString())
        }
    }

    JSONParser(String string, String schema = null) throws JsonException {
        file = null
        data = openString(string)
	    Set valid = validate(schema)
	    if (schema != null && valid.size() > 0) {
		    throw new JsonException(valid.toString())
	    }
    }
}
