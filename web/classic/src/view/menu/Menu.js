Ext.define('MPortal.view.menu.Menu', {
    extend: 'Ext.panel.Panel',
    xtype: 'm-menu',
    
    controller: 'm-menu',
    
    requires: [
        'Ext.layout.container.Border'
    ],
    //<example>
    exampleTitle: 'Border Layout',
    profiles: {
        classic: {
            width: 520
        },
        gray: {
            width: 520
        },
        neptune: {
            width: 590
        },
        'neptune-touch': {
            width: 700
        }
    },
    //</example>
    
    layout: 'border',
    width: '100%',
    height: 500,

    bodyBorder: false,
    
    defaults: {
        collapsible: true,
        split: true
//        bodyPadding: 10
    },

    items: [{
        region:'west',
        reference: 'menu-tree',
        xtype: 'menu-tree',
        floatable: false,
        margin: '5 0 0 0',
        width: '100%',
        minWidth: 100,
        maxWidth: 250
    },{
    	region: 'center',
    	xtype: 'menu-form',
        collapsible: false,
        margin: '5 0 0 0'
    }]

});