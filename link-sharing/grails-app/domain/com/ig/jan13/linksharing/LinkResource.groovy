package com.ig.jan13.linksharing

class LinkResource extends Resource{
                              String url
    static constraints = {
        url(url: true)
    }
}
