Ext.define('MPortal.view.user.User', {
    extend: 'Ext.form.Panel',
    xtype: 'user',
    
    controller: 'user',
    
    //<example>
    exampleTitle: '用户信息',
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
    
    title: '用户信息',
    frame: true,
    resizable: true,
    minHeight: 200,

    layout: 'fit',
    
    defaults: {
        layout: 'form',
        xtype: 'container',
        defaultType: 'textfield',
        style: 'width: 100%'
    },
    
    items: [{
        items: [
            { name: 'username', fieldLabel: 'username' },
            { name: 'password', fieldLabel: 'password' }
        ]
    }],
    
    buttons: [
        { text: 'OK', handler: 'onOkClick' },
        { text: 'Cancel' }
    ],
    
    initComponent: function() {
        this.width = this.profileInfo.width;
        this.minWidth = this.profileInfo.width;
        this.callParent();
    }
});