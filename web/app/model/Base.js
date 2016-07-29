Ext.define('MPortal.model.Base', {
    extend: 'Ext.data.Model',
    
    fields: [{
        name: 'id',
        type: 'int',
        persist: false
    }],
    
    schema: {
        namespace: 'MPortal.model'
    }
});