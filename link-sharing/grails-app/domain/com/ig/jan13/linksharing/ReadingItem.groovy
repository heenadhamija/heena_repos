package com.ig.jan13.linksharing

class ReadingItem {
    boolean isRead,isFavourite

    Resource resource
    static belongsTo = [user:User]
    static constraints = {
    }

}
