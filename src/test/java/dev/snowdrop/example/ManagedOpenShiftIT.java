package dev.snowdrop.example;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import io.dekorate.testing.annotation.Inject;
import io.dekorate.testing.openshift.annotation.OpenshiftIntegrationTest;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.LocalPortForward;

@DisabledIfSystemProperty(named = "unmanaged-test", matches = "true")
@OpenshiftIntegrationTest
public class ManagedOpenShiftIT extends AbstractExampleApplicationTest {

    @Inject
    KubernetesClient client;

    @Inject
    Pod pod;

    LocalPortForward appPort;

    @BeforeEach
    public void setup() {
        appPort = client.pods().withName(pod.getMetadata().getName()).portForward(8080);
    }

    @AfterEach
    public void tearDown() throws IOException {
        if (appPort != null) {
            appPort.close();
        }
    }

    @Override
    public String baseURI() {
        return "http://localhost:" + appPort.getLocalPort() + "/";
    }
}
