package com.ig.jan13.linksharing

class ApplicationTagLib {
      static namespace = "ls"
      def unreadItems={attrs ->
          List unread=attrs['count']

          out << unread



    }

}
