Ext.define('MPortal.model.Menu', {
	extend: 'MPortal.model.Base',
	alias: 'model.m-menu',
    fields: [
        { name: 'code', type: 'string' },
        { name: 'name', type: 'string' },
        { name: 'parentId', type: 'string' }
    ],
    
    proxy: {
    	type: 'rest',
        url: 'http://localhost:8080/menus',
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json'
        }
    }
});