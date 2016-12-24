Ext.define('MPortal.store.Menus', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.menus',
    storeId: 'menus',
    
    model: 'MPortal.model.Menu',
    autoLoad: true,
    autoSync: true,

    constructor: function(config) {
        var me = this;

        me.callParent([Ext.apply({
            root: {
                text: '系统菜单',
                id: '0',
                code: '0',
                expanded: true
            }
        }, config)]);
    },
    
    proxy: {
    	type: 'rest',
//    	url: 'http://localhost:8080/menus/',
        api: {
            create  : 'http://localhost:8080/menus/create',
            read    : 'http://localhost:8080/menus/tree/children',
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
