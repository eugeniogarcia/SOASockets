importPackage(java.io);
importPackage(java.lang);
importPackage(javax.xml.parsers);

println("=====> Under Script Execution");
var inputStream = InputStreamKey;
var outputStream = OutputStreamKey;
var requestPayloadElement = RequestPayloadElementKey;
var ReplyDOMResult = ReplyDOMResultKey;

var isr = new InputStreamReader(inputStream);
var osw = new OutputStreamWriter(outputStream);
var br = new BufferedReader(isr);

println("=====> starting handshake");
var reply = doHandshake();

createDOM(reply);

function writeToServer(request) {
    println("=====> Under writeToServer");
    var bw = new BufferedWriter(osw);
    bw.write(request);
    bw.newLine();
    bw.flush();
}

function doHandshake() {
    println("=====> Under extractPayload ");
    var nodeList = requestPayloadElement.getChildNodes();
    var length = nodeList.getLength();
    println("=====> Length :" + length);
    //var i = 0;
    var name = "";
    var empId = "";
    for(var i=0 ; i < length; i++){
        println("===> Name" + i + "=" + nodeList.item(i).getNodeName());
        if(nodeList.item(i).getNodeName().indexOf("Name")!= -1){
            name = nodeList.item(i).getFirstChild().getNodeValue();
            println("=====> name :"+name);
        }
        else if(nodeList.item(i).getNodeName().indexOf("EmpId")!= -1){
            empId = nodeList.item(i).getFirstChild().getNodeValue();
            println("=====> empId :"+empId);
        }
    }
    println("=====> name :"+name);
    println("=====> empId :"+empId);
    var xmlPayload = "Hello World";/*"<ns1:Inbound-Element
    xmlns:ns1=\"http://xmlns.oracle.com/pcbpel/demoSchema/csv\"><ns1:Name>" + name +
    "</ns1:Name>" +
    "<ns1:EmpId>" + empId +"</ns1:EmpId></ns1:Inbound-Element>";*/
    println("=====> xmlPayload :"+xmlPayload);
    writeToServer(name);
    writeToServer(empId);
    osw.close();
    var code = readFromServer();
    return code;
}

function readFromServer() {
    println("=====> Under readFromServer ");
    var str = ""; //= br.readLine();
    var tmpStr = "";
    while (true){
        tmpStr = br.readLine();
        if(tmpStr == -1 || tmpStr == null) break;
        println("tmpStr=" + tmpStr);
        str += tmpStr;
    }
    println("=====> Reply from Server :"+str);
    return str;
}

function createDOM(code){
    println("=====> Under createDOM "); ;
    var fRootNode = null;
    var fDocument = null;
    var fTempNode = null;
    var NAMESPACE = "http://xmlns.oracle.com/pcbpel/demoSchema/csv";
    var ROOT_NODE = "Result";
    var dbf = DocumentBuilderFactory.newInstance();
    var db = dbf.newDocumentBuilder();
    fDocument = db.newDocument();
    fRootNode = fDocument.createElementNS(NAMESPACE, ROOT_NODE);
    fRootNode.appendChild(fDocument.createTextNode(code));
    ReplyDOMResult.setNode(fRootNode);
}