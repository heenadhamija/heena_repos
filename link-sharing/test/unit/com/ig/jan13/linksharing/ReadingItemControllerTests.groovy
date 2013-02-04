package com.ig.jan13.linksharing



import org.junit.*
import grails.test.mixin.*

@TestFor(ReadingItemController)
@Mock(ReadingItem)
class ReadingItemControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/readingItem/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.readingItemInstanceList.size() == 0
        assert model.readingItemInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.readingItemInstance != null
    }

    void testSave() {
        controller.save()

        assert model.readingItemInstance != null
        assert view == '/readingItem/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/readingItem/show/1'
        assert controller.flash.message != null
        assert ReadingItem.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/readingItem/list'

        populateValidParams(params)
        def readingItem = new ReadingItem(params)

        assert readingItem.save() != null

        params.id = readingItem.id

        def model = controller.show()

        assert model.readingItemInstance == readingItem
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/readingItem/list'

        populateValidParams(params)
        def readingItem = new ReadingItem(params)

        assert readingItem.save() != null

        params.id = readingItem.id

        def model = controller.edit()

        assert model.readingItemInstance == readingItem
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/readingItem/list'

        response.reset()

        populateValidParams(params)
        def readingItem = new ReadingItem(params)

        assert readingItem.save() != null

        // test invalid parameters in update
        params.id = readingItem.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/readingItem/edit"
        assert model.readingItemInstance != null

        readingItem.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/readingItem/show/$readingItem.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        readingItem.clearErrors()

        populateValidParams(params)
        params.id = readingItem.id
        params.version = -1
        controller.update()

        assert view == "/readingItem/edit"
        assert model.readingItemInstance != null
        assert model.readingItemInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/readingItem/list'

        response.reset()

        populateValidParams(params)
        def readingItem = new ReadingItem(params)

        assert readingItem.save() != null
        assert ReadingItem.count() == 1

        params.id = readingItem.id

        controller.delete()

        assert ReadingItem.count() == 0
        assert ReadingItem.get(readingItem.id) == null
        assert response.redirectedUrl == '/readingItem/list'
    }
}
