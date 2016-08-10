Ext.define('MPortal.view.menu.MenuTree', {
    extend: 'Ext.tree.Panel',

    xtype: 'menu-tree',
    id: 'menu-tree',

    title: '菜单列表',
    rootVisible: false,
    lines: false,
    useArrows: true,
    hideHeaders: true,
    collapseFirst: false,
    frame: true,
    width: 250,
    minWidth: 100,
    height: 200,
    split: true,
    stateful: true,
    stateId: 'menu-tree',
    collapsible: true,
    
    columns: [{
        xtype: 'treecolumn',
        flex: 1,
        dataIndex: 'text',
        scope: 'controller'
    }],

    store: 'menus'
});
