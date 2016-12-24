Ext.define('MPortal.model.Base', {
    extend: 'Ext.data.Model',
    
    fields: [{
        name: 'id',
        type: 'string',
        persist: false
    }],
    
    schema: {
        namespace: 'MPortal.model'
    }
});