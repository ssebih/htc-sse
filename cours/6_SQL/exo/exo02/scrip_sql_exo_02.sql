<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0102)https://mail.ovh.net/roundcube/?_task=mail&_frame=1&_mbox=INBOX&_uid=102&_part=2&_action=get&_extwin=1 -->
<html lang="fr" xmlns="http://www.w3.org/1999/xhtml" class=" js chrome webkit"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Roundcube Webmail 1.4.13 :: scrip_sql_exo_02.sql</title>
<link rel="index" href="https://mail.ovh.net/roundcube/?_task=mail">

<link rel="shortcut icon" href="https://mail.ovh.net/roundcube/skins/classic/images/favicon.ico?s=1642082463">

<link rel="stylesheet" type="text/css" href="./scrip_sql_exo_02_files/common.min.css">
<link rel="stylesheet" type="text/css" href="./scrip_sql_exo_02_files/mail.min.css">

<link rel="stylesheet" type="text/css" href="./scrip_sql_exo_02_files/jquery-ui.css">
<script type="text/javascript" src="./scrip_sql_exo_02_files/splitter.min.js.téléchargement"></script>
<script type="text/javascript" src="./scrip_sql_exo_02_files/functions.min.js.téléchargement"></script>
<style type="text/css">
#messagepartheader { width: 144px; }
#messagepartcontainer { left: 154px; }
</style>
<script src="./scrip_sql_exo_02_files/jquery.min.js.téléchargement" type="text/javascript"></script>
<script src="./scrip_sql_exo_02_files/common.min.js.téléchargement" type="text/javascript"></script>
<script src="./scrip_sql_exo_02_files/app.min.js.téléchargement" type="text/javascript"></script>
<script type="text/javascript">
/* <![CDATA[ */
/*
        @licstart  The following is the entire license notice for the 
        JavaScript code in this page.

        Copyright (C) The Roundcube Dev Team

        The JavaScript code in this page is free software: you can redistribute
        it and/or modify it under the terms of the GNU General Public License
        as published by the Free Software Foundation, either version 3 of
        the License, or (at your option) any later version.

        The code is distributed WITHOUT ANY WARRANTY; without even the implied
        warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
        See the GNU GPL for more details.

        @licend  The above is the entire license notice
        for the JavaScript code in this page.
*/
var rcmail = new rcube_webmail();
rcmail.set_env({"task":"mail","standard_windows":false,"locale":"fr_FR","devel_mode":null,"rcversion":10413,"cookie_domain":"","cookie_path":"/","cookie_secure":true,"skin":"classic","extwin":1,"blankpage":"skins/classic/watermark.html","refresh_interval":60,"session_lifetime":172800,"action":"get","comm_path":"./?_task=mail","user_id":"zJkGUAeruPsX7Hxk","compose_extwin":false,"date_format":"yy-mm-dd","date_format_localized":"AAAA-MM-JJ","browser_capabilities":{"pdf":"1","flash":"0","tiff":"0","webp":"1"},"mailbox":"INBOX","uid":"102","part":"2","filename":"scrip_sql_exo_02.sql","mimetype":"text/plain","request_token":"davEJPXpMCFzDsEzvj2WbxdRy87FE0IQ"});
rcmail.add_label({"loading":"Chargement\u2026","servererror":"Erreur de serveur","connerror":"Erreur de connexion (n\u2019a pu atteindre le serveur)","requesttimedout":"D\u00e9lai de la requ\u00eate expir\u00e9","refreshing":"Actualisation\u2026","windowopenerror":"La fen\u00eatre surgissante a \u00e9t\u00e9 bloqu\u00e9e","uploadingmany":"T\u00e9l\u00e9versement des fichiers\u2026","uploading":"T\u00e9l\u00e9versement du fichier\u2026","close":"Fermer","save":"Enregistrer","cancel":"Annuler","alerttitle":"Attention","confirmationtitle":"\u00cates-vous certain\u2026","delete":"Supprimer","continue":"Continuer","ok":"OK"});
rcmail.gui_container("toolbar","messagetoolbar");rcmail.gui_object('message', 'message');
rcmail.register_button('download', 'rcmbtn100', 'link', 'button download', 'button downloadSel', '');
rcmail.register_button('print', 'rcmbtn101', 'link', 'button print', 'button printSel', '');
rcmail.gui_object('messagepartframe', 'messagepartframe');
/* ]]> */
</script>

<script src="./scrip_sql_exo_02_files/jquery-ui.min.js.téléchargement" type="text/javascript"></script>
<script src="./scrip_sql_exo_02_files/jquery.ui.datepicker-fr.js.téléchargement" type="text/javascript"></script>

</head>
<body class="extwin">
<div id="message"></div>

<div id="messagetoolbar">
    <a class="button download" title="Télécharger" id="rcmbtn100" role="button" tabindex="0" aria-disabled="false" href="https://mail.ovh.net/roundcube/?_task=mail&amp;_frame=1&amp;_mbox=INBOX&amp;_uid=102&amp;_part=2&amp;_action=get&amp;_extwin=1#" onclick="return rcmail.command(&#39;download&#39;,&#39;&#39;,this,event)"> </a>
    <a class="button print" title="Imprimer" id="rcmbtn101" role="button" tabindex="0" aria-disabled="false" href="https://mail.ovh.net/roundcube/?_task=mail&amp;_frame=1&amp;_mbox=INBOX&amp;_uid=102&amp;_part=2&amp;_action=get&amp;_extwin=1#" onclick="return rcmail.command(&#39;print&#39;,&#39;&#39;,this,event)"> </a>
    
    </div>

<div id="mainscreen">
    <div id="messagepartheader" style="width: 144px;">
        <div class="boxtitle">Propriétés</div>
        <div class="boxlistcontent">
            <table summary="" border="0" class="records-table" cellspacing="0"><tbody><tr><td class="title">Nom:</td>
<td class="header">scrip_sql_exo_02.sql</td>
</tr>
<tr><td class="title">Type:</td>
<td class="header">text/plain</td>
</tr>
<tr><td class="title">Taille:</td>
<td class="header">~4 ko</td>
</tr>
</tbody>
</table>

        </div>
    </div>
    <div id="messagepartcontainer" style="left: 154px;">
        <iframe name="messagePartFrame" id="messagepartframe" width="100%" height="100%" src="./scrip_sql_exo_02_files/saved_resource.html"></iframe>
    </div>
<div id="mailpartsplitter" class="splitter splitter-v" style="position: absolute; visibility: visible; left: 145px; top: 0px; width: 10px; height: 100%;"></div></div>

<script type="text/javascript">
var mailpartsplit = new rcube_splitter({id:'mailpartsplitter', p1: 'messagepartheader', p2: 'messagepartcontainer', orientation: 'v', relative: true, start: 165});
rcmail.add_onload('mailpartsplit.init()');
rcube_init_mail_ui();
</script>
<script type="text/javascript">
/* <![CDATA[ */
$(function() {
rcmail.init();
});
/* ]]> */
</script>




</body></html>