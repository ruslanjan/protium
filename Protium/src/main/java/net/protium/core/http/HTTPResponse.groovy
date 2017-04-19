/*
 * Copyright (C) 2017 Protium - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package net.protium.core.http

import net.protium.api.events.Response

/**
 * From: protium
 * Pkg: net.protium.core.http
 * At: 10.04.17
 */
class HTTPResponse implements Response {

    String contentType, response
    Integer status

    @Override
    String getContentType() { contentType }

    void setContentType(String type) {
        contentType = type
    }

    @Override
    String getResponse() {
        response
    }

    void setResponse(String response) {
        this.response = response
    }

    @Override
    Integer getStatus() {
        status
    }
}