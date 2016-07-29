Ext.define('MPortal.model.User', {
    extend: 'MPortal.model.Base',
    alias: 'model.user',
    
    fields: ['username', 'email'],
    
    proxy: {
    	type: 'rest',
        url: '/user',
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json'
        }
    }
    
});