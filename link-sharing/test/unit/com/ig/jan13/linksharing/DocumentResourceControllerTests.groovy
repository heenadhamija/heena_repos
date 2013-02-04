package com.ig.jan13.linksharing



import org.junit.*
import grails.test.mixin.*

@TestFor(DocumentResourceController)
@Mock(DocumentResource)
class DocumentResourceControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/documentResource/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.documentResourceInstanceList.size() == 0
        assert model.documentResourceInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.documentResourceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.documentResourceInstance != null
        assert view == '/documentResource/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/documentResource/show/1'
        assert controller.flash.message != null
        assert DocumentResource.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/documentResource/list'

        populateValidParams(params)
        def documentResource = new DocumentResource(params)

        assert documentResource.save() != null

        params.id = documentResource.id

        def model = controller.show()

        assert model.documentResourceInstance == documentResource
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/documentResource/list'

        populateValidParams(params)
        def documentResource = new DocumentResource(params)

        assert documentResource.save() != null

        params.id = documentResource.id

        def model = controller.edit()

        assert model.documentResourceInstance == documentResource
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/documentResource/list'

        response.reset()

        populateValidParams(params)
        def documentResource = new DocumentResource(params)

        assert documentResource.save() != null

        // test invalid parameters in update
        params.id = documentResource.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/documentResource/edit"
        assert model.documentResourceInstance != null

        documentResource.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/documentResource/show/$documentResource.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        documentResource.clearErrors()

        populateValidParams(params)
        params.id = documentResource.id
        params.version = -1
        controller.update()

        assert view == "/documentResource/edit"
        assert model.documentResourceInstance != null
        assert model.documentResourceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/documentResource/list'

        response.reset()

        populateValidParams(params)
        def documentResource = new DocumentResource(params)

        assert documentResource.save() != null
        assert DocumentResource.count() == 1

        params.id = documentResource.id

        controller.delete()

        assert DocumentResource.count() == 0
        assert DocumentResource.get(documentResource.id) == null
        assert response.redirectedUrl == '/documentResource/list'
    }
}
