/**
 * This entity represents a project which is a container for tickets.
 */
Ext.define('MPortal.model.Project', {
    extend: 'MPortal.model.Base',

    fields: [
        'name',
        { name: 'organizationId', reference: 'Organization' }, {
            name: 'leadId',
            unique: true,
            reference: 'User'
        }
    ]
});
