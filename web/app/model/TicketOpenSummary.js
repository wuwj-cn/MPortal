Ext.define('MPortal.model.TicketOpenSummary', {
    extend: 'Ext.data.Model',
    fields: ['total', {
        name: 'date',
        type: 'date',
        dateFormat: 'Y-m-d'
    }]
});