package aasdntool;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jediterm.pty.PtyProcessTtyConnector;
import com.jediterm.terminal.LoggingTtyConnector;
import com.jediterm.terminal.TtyConnector;
import com.jediterm.terminal.ui.AbstractTerminalFrame;
import com.jediterm.terminal.ui.UIUtil;
import com.pty4j.PtyProcess;

public class TerminalPty extends AbstractTerminalFrame {

	@Override
	public TtyConnector createTtyConnector() {
		try {
			Map<String, String> envs = Maps.newHashMap(System.getenv());
			envs.put("TERM", "xterm");
			String[] command = new String[] { "/bin/bash", "--login","-c",Login.terminalCommand};
			System.out.println(Login.terminalCommand);

			if (UIUtil.isWindows) {
				command = new String[] { "cmd.exe" };
			}

			PtyProcess process = PtyProcess.exec(command, envs, null);

			return new LoggingPtyProcessTtyConnector(process, Charset.forName("UTF-8"));
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}


	public static class LoggingPtyProcessTtyConnector extends PtyProcessTtyConnector implements LoggingTtyConnector {
		private List<char[]> myDataChunks = Lists.newArrayList();

		public LoggingPtyProcessTtyConnector(PtyProcess process, Charset charset) {
			super(process, charset);
		}

		@Override
		public int read(char[] buf, int offset, int length) throws IOException {
			int len = super.read(buf, offset, length);
			if (len > 0) {
				char[] arr = Arrays.copyOfRange(buf, offset, len);
				myDataChunks.add(arr);
			}
			return len;
		}

		public List<char[]> getChunks() {
			return Lists.newArrayList(myDataChunks);
		}

		@Override
		public void write(String string) throws IOException {
			LOG.debug("Writing in OutputStream : " + string);
			super.write(string);
		}

		@Override
		public void write(byte[] bytes) throws IOException {
			LOG.debug("Writing in OutputStream : " + Arrays.toString(bytes) + " " + new String(bytes));
			super.write(bytes);
		}
	}

}
