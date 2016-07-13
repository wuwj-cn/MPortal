/**
 * This entity represents a comment on a ticket made by a particular user.
 */
Ext.define('MPortal.model.Comment', {
    extend: 'MPortal.model.Base',
    
    requires: [
        'MPortal.override.data.field.Date'
    ],

    fields: [
        // 'text', // undeclared on purpose
        { name: 'created', type: 'date' },
        { name: 'lastEdited', type: 'date' },
        { name: 'ticketId', reference: { parent: 'Ticket' } },
        { name: 'userId', reference: 'User' }
    ]
});
