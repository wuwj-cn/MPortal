Ext.define('MPortal.view.CodePreview', {
    extend: 'Ext.tab.Panel',
    requires: [
        'MPortal.view.CodeContent'
    ],

    xtype: 'codePreview',

    // The code must be read in LTR
    bodyPadding: 5,
    bodyStyle: 'direction: ltr;',

    tools: [{
        type: 'maximize',
        tooltip: 'Maximize example code content'
    }],
    showTitle: true,

    initComponent: function() {
        if (this.showTitle) {
            this.title = 'Details';
        }
        this.callParent(arguments);
    }
});