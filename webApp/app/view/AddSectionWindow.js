/*
 * File: app/view/AddSectionWindow.js
 *
 * This file was generated by Sencha Architect version 4.2.5.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 6.6.x Classic library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 6.6.x Classic. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('MyApp.view.AddSectionWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.addsectionwindow',

    requires: [
        'MyApp.view.AddSectionWindowViewModel',
        'MyApp.view.AddSectionWindowViewController',
        'Ext.form.Panel',
        'Ext.form.field.ComboBox',
        'Ext.form.field.TextArea',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Fill',
        'Ext.button.Button'
    ],

    controller: 'addsectionwindow',
    viewModel: {
        type: 'addsectionwindow'
    },
    height: 380,
    id: 'newSectionWindow',
    width: 400,
    title: 'Добавление нового раздела',

    items: [
        {
            xtype: 'form',
            reference: 'AddSectionForm',
            height: 340,
            bodyPadding: 10,
            jsonSubmit: false,
            method: 'POST',
            standardSubmit: false,
            url: '/api/sections',
            items: [
                {
                    xtype: 'combobox',
                    anchor: '100%',
                    reference: 'documentComboBox',
                    fieldLabel: 'Документ:',
                    name: 'documentId',
                    allowBlank: false,
                    editable: false,
                    displayField: 'header',
                    forceSelection: true,
                    store: 'DocumentsStore',
                    valueField: 'id'
                },
                {
                    xtype: 'textfield',
                    anchor: '100%',
                    fieldLabel: 'Заголовок',
                    name: 'title',
                    allowBlank: false
                },
                {
                    xtype: 'textareafield',
                    anchor: '100%',
                    height: 230,
                    fieldLabel: 'Содержание',
                    name: 'text',
                    allowBlank: false
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'bottom',
                    items: [
                        {
                            xtype: 'tbfill'
                        },
                        {
                            xtype: 'button',
                            text: 'Отмена',
                            listeners: {
                                click: 'onCancelButtonClick'
                            }
                        },
                        {
                            xtype: 'button',
                            text: 'Добавить',
                            listeners: {
                                click: 'onAddSectionClick'
                            }
                        }
                    ]
                }
            ]
        }
    ]

});