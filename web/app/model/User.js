/**
 * This view is used to present the details of a single Ticket.
 */
Ext.define('MPortal.model.User', {
    extend: 'MPortal.model.Base',

    fields: [
        'name',
        { name: 'organizationId', reference: 'Organization' },
        { name: 'projectId', reference: 'Project' }
    ],

    manyToMany: 'Group'
});
