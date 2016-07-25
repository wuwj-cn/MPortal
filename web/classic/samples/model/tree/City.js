Ext.define('MPortal.model.tree.City', {
    extend: 'MPortal.model.tree.Base',
    entityName: 'City',
    idProperty: 'name',
    fields: [{
        name: "name",
        convert: undefined
    }]
});