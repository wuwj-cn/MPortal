/**
 * This class describes a group of users.
 */
Ext.define('MPortal.model.Group', {
    extend: 'MPortal.model.Base',

    fields: [
        'name',
        { name: 'organizationId', reference: 'Organization' }
    ],

    manyToMany: 'User'
});
