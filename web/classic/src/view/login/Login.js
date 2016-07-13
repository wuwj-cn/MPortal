Ext.define('MPortal.view.login.Login', {
    extend: 'Ext.window.Window',
    
    requires: [
        'MPortal.view.login.LoginController',
        'MPortal.view.login.LoginModel',
        'Ext.form.Panel',
        'Ext.button.Button',
        'Ext.form.field.Text',
        'Ext.form.field.ComboBox'
    ],
    
    viewModel: 'login',
    
    controller: 'login',
    bodyPadding: 10,
    title: 'Login - MPortal App',
    closable: false,
    
    cls: 'login',
    
    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
            xtype: 'textfield',
            name: 'username',
            bind: '{username}',
            fieldLabel: '用户名',
            allowBlank: false,
            enableKeyEvents: true,
            listeners: {
                specialKey: 'onSpecialKey'
            }
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: '密码',
            allowBlank: false,
            enableKeyEvents: true,
            cls: 'password',
            listeners: {
                specialKey: 'onSpecialKey'
            }
        }, {
            xtype: 'displayfield',
            hideEmptyLabel: false,
            value: 'Enter any non-blank password',
            cls: 'hint'
        }]
    },

    buttons: [{
        text: 'Login',
        listeners: {
            click: 'onLoginClick'
        }
    }]
});
