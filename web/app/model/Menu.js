Ext.define('MPortal.model.Menu', {
	extend: 'MPortal.model.Base',
	alias: 'model.m-menu',
    fields: [
        { name: 'code', type: 'string' },
        { name: 'name', type: 'string' }
    ],
    
    proxy: {
    	type: 'rest',
//        url: 'http://localhost:8080/menus/list',
    	api: {
            create  : 'http://localhost:8080/menus/create',
            read    : 'http://localhost:8080/menus/list',
            update  : 'http://localhost:8080/menus/update',
            destroy : 'http://localhost:8080/menus/delete'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json'
        }
    }
});