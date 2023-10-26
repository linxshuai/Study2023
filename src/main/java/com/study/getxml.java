import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.StringReader;
import org.xml.sax.InputSource;

public class getxml {
    public static void main(String[] args) {
        String xml = "<cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>\\n\" +\n" +
                "                \"    <cas:authenticationSuccess>\\n\" +\n" +
                "                \"        <cas:user>888883</cas:user>\\n\" +\n" +
                "                \"        <!-- Start edit: additional attribute passed to client -->\\n\" +\n" +
                "                \"            <cas:attributes>\\n\" +\n" +
                "                \"                    <cas:InstIdBdy>0108A4H</cas:InstIdBdy>\\n\" +\n" +
                "                \"                    <cas:loginAccount>888883</cas:loginAccount>\\n\" +\n" +
                "                \"                    <cas:FaceVrfyPsTm></cas:FaceVrfyPsTm>\\n\" +\n" +
                "                \"                    <cas:MoreFatrMark>0</cas:MoreFatrMark>\\n\" +\n" +
                "                \"                    <cas:loginType>SN</cas:loginType>\\n\" +\n" +
                "                \"                    <cas:HmnRsrcID1>888883</cas:HmnRsrcID1>\\n\" +\n" +
                "                \"                    <cas:UsrLogonNm>888883</cas:UsrLogonNm>\\n\" +\n" +
                "                \"                    <cas:userName>开发测试</cas:userName>\\n\" +\n" +
                "                \"                    <cas:Name>888883</cas:Name>\\n\" +\n" +
                "                \"                    <cas:MoreFatrInf></cas:MoreFatrInf>\\n\" +\n" +
                "                \"                    <cas:MblNoCtfctnTm></cas:MblNoCtfctnTm>\\n\" +\n" +
                "                \"                    <cas:MblNo>19122220005</cas:MblNo>\\n\" +\n" +
                "                \"                    <cas:PrsnTp>H</cas:PrsnTp>\\n\" +\n" +
                "                \"                    <cas:sn>888883</cas:sn>\\n\" +\n" +
                "                \"                    <cas:SysUsrNo>d9fc1d587194</cas:SysUsrNo>\\n\" +\n" +
                "                \"                    <cas:NotesId>888883</cas:NotesId>\\n\" +\n" +
                "                \"                    <cas:PrsnNo>888883</cas:PrsnNo>\\n\" +\n" +
                "                \"                    <cas:IdentNo>888888888888888883</cas:IdentNo>\\n\" +\n" +
                "                \"                    <cas:PswdOvtmRmanDays>70</cas:PswdOvtmRmanDays>\\n\" +\n" +
                "                \"            </cas:attributes>\\n\" +\n" +
                "                \"        <!-- end edit by Anthony on 2011-10-01 -->        \\n\" +\n" +
                "                \"    </cas:authenticationSuccess>\\n\" +\n" +
                "                \"</cas:serviceResponse>";

        System.out.println("NotesId: " + getValueFromXML(xml, "NotesId"));
        System.out.println("userName: " + getValueFromXML(xml, "userName"));
        System.out.println("MblNo: " + getValueFromXML(xml, "MblNo"));
        String NotesId=getValueFromXML(xml, "NotesId");
        String email = NotesId + "@cib.com.cn";
        System.out.println(email);
    }

    public static String getValueFromXML(String xml, String tagName) {
        try {
            // Load XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            // Get root element
            Element rootElement = document.getDocumentElement();

            // Get specified element
            NodeList nodeList = rootElement.getElementsByTagNameNS("http://www.yale.edu/tp/cas", tagName);
            if (nodeList.getLength() > 0) {
                Node node = nodeList.item(0);
                return node.getTextContent();
            } else {
                return "Not found in the XML.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("XML is null");
        }
    }
}