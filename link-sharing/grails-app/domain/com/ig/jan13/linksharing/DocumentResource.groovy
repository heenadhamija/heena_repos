package com.ig.jan13.linksharing

class DocumentResource extends Resource {
                                        String fileName
                                        String contentType
    static constraints = {
        fileName(nullable: false,blank: false)
        contentType(blank: false,nullable: false)
    }
}
