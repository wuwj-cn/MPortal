Ext.define('MPortal.store.Menus', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.menus',
    storeId: 'menus',
    autoLoad: true,
    autoSync: true,

    constructor: function(config) {
        var me = this;

        me.callParent([Ext.apply({
            root: {
                text: 'ROOT',
                id: '0',
                expanded: true,
                children: me.data
            }
        }, config)]);
    },
    
    proxy: {
    	type: 'rest',
        url: '/menus/tree',
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json'
        }
    }
});
